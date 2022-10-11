package com.masai.service;

import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.VehicleOwnerException;
import com.masai.model.TollToken;
import com.masai.model.VehicleOwner;
import com.masai.repository.TolltokenDAO;
import com.masai.repository.VehicleOwnerDAO;

@Service
public class TollTokenServiceImp implements TollTokenService{
	@Autowired
	private TolltokenDAO  tolltokenDAO;
	
	@Autowired
	private VehicleOwnerDAO vehicleOwnerDAO;
   
    
	@Override
	public TollToken saveToken(TollToken tolltoken) {
		// TODO Auto-generated method stub
		//System.out.println(tolltoken.getLocalDateTime().getHour());
		TollToken message=null;
		HashMap<String,Integer> charges=new HashMap<>();
		// car/truck/semi-trailer/bus
		charges.put("car", 150);
		charges.put("truck", 250);
		charges.put("semi-trailer", 350);
		charges.put("bus", 500);
		HashMap<String,Integer> discount10=new HashMap<>();
		discount10.put("car", 150-15);
		discount10.put("truck", 250-25);
		discount10.put("semi-trailer", 350-35);
		discount10.put("bus", 500-50);
		Optional<VehicleOwner> opt=vehicleOwnerDAO.findById(tolltoken.getRFID());
		if(opt.isPresent()) {
			VehicleOwner owner=opt.get();
			Optional<List<TollToken>> toll=tolltokenDAO.findByRFID(tolltoken.getRFID());
			List<TollToken>tollList=toll.get();
			long day=-1;
			System.out.println();
			if(tollList.size()!=0) {
			TollToken t =tollList.get(tollList.size()-1);
		   
			 day=ChronoUnit.DAYS.between(t.getLocalDateTime(), tolltoken.getLocalDateTime());
			}
			
			if(day==0) {
				
					if(tollList.get(tollList.size()-1).getBooth_location().equals(tolltoken.getBooth_location()) && tollList.get(tollList.size()-1).getTollBooth_No()==tolltoken.getTollBooth_No()){
						message= tolltokenDAO.save(tolltoken);
					}else {
						String vehicle=tolltoken.getVehicleType();
						if(owner.getWallet()>=discount10.get(vehicle)) {
							tolltoken.setCharge(tolltoken.getCharge()+discount10.get(vehicle));
							owner.setWallet(owner.getWallet()-discount10.get(vehicle));
							message= tolltokenDAO.save(tolltoken);
							
						}else {
							throw new VehicleOwnerException("oops !Low Balance in your wallet");
						}
					}
					
					
				}else {
					String vehicle=tolltoken.getVehicleType();
					if(owner.getWallet()>=charges.get(vehicle)) {
						tolltoken.setCharge(tolltoken.getCharge()+charges.get(vehicle));
						owner.setWallet(owner.getWallet()-charges.get(vehicle));
						message= tolltokenDAO.save(tolltoken);
					}else {
						throw new VehicleOwnerException("oops !Low Balance in your wallet");
					}
				}
				
		}else {
				if(charges.containsKey(tolltoken.getVehicleType())) {
					throw new VehicleOwnerException("Please register your vehicle in RFID");
					
				}else {
					message= tolltokenDAO.save(tolltoken);
				}
		}
		
		return message;

	}

	@Override
	public List<TollToken> getAllTollToken() {
		// TODO Auto-generated method stub
		return tolltokenDAO.findAll();
	}

}
