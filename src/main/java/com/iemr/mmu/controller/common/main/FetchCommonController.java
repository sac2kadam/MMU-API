package com.iemr.mmu.controller.common.main;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iemr.mmu.service.common.transaction.CommonDoctorServiceImpl;
import com.iemr.mmu.service.common.transaction.CommonNurseServiceImpl;
import com.iemr.mmu.utils.response.OutputResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin
@RestController
@RequestMapping(value = "/common", headers = "Authorization")
public class FetchCommonController {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	private CommonDoctorServiceImpl commonDoctorServiceImpl;
	private CommonNurseServiceImpl commonNurseServiceImpl;

	@Autowired
	public void setCommonDoctorServiceImpl(CommonDoctorServiceImpl commonDoctorServiceImpl) {
		this.commonDoctorServiceImpl = commonDoctorServiceImpl;
	}

	@Autowired
	public void setCommonNurseServiceImpl(CommonNurseServiceImpl commonNurseServiceImpl) {
		this.commonNurseServiceImpl = commonNurseServiceImpl;
	}

	@CrossOrigin()
	@ApiOperation(value = "provides doctor worklist", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getDocWorklist" }, method = { RequestMethod.GET })
	public String getDocWorkList() {
		OutputResponse response = new OutputResponse();
		try {
			String s = commonDoctorServiceImpl.getDocWorkList();
			response.setResponse(s);
		} catch (Exception e) {
			logger.error("Error in getDocWorkList:" + e);
			response.setError(e);
		}
		return response.toString();
	}

	// doc worklist new
	@CrossOrigin()
	@ApiOperation(value = "provides doctor worklist", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getDocWorklistNew" }, method = { RequestMethod.GET })
	public String getDocWorkListNew() {
		OutputResponse response = new OutputResponse();
		try {
			String s = commonDoctorServiceImpl.getDocWorkListNew();
			response.setResponse(s);
		} catch (Exception e) {
			logger.error("Error in getDocWorkList:" + e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Nurse worklist", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getNurseWorklist" }, method = { RequestMethod.GET })
	public String getNurseWorkList() {
		OutputResponse response = new OutputResponse();
		try {
			String s = commonNurseServiceImpl.getNurseWorkList();
			response.setResponse(s);
		} catch (Exception e) {
			// e.printStackTrace();
			logger.error("Error in getNurseWorklist:" + e);
			response.setError(e);
		}
		return response.toString();
	}

	// nurse worklist new
	@CrossOrigin()
	@ApiOperation(value = "Get Nurse worklist new", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getNurseWorklistNew" }, method = { RequestMethod.GET })
	public String getNurseWorkListNew() {
		OutputResponse response = new OutputResponse();
		try {
			String s = commonNurseServiceImpl.getNurseWorkListNew();
			if (s != null)
				response.setResponse(s);
			else
				response.setError(5000, "Error while fetching Nurse worklist");
		} catch (Exception e) {
			// e.printStackTrace();
			logger.error("Error in getNurseWorklist:" + e);
			response.setError(e);
		}
		return response.toString();
	}

	@CrossOrigin()
	@ApiOperation(value = "Get Doctor Entered Previous significant Findings", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getDoctorPreviousSignificantFindings" }, method = { RequestMethod.POST })
	public String getDoctorPreviousSignificantFindings(
			@ApiParam(value = "{\"beneficiaryRegID\": \"Long\"}") @RequestBody String comingRequest) {
		OutputResponse response = new OutputResponse();
		try {
			JSONObject obj = new JSONObject(comingRequest);
			if (obj != null && obj.has("beneficiaryRegID") && obj.get("beneficiaryRegID") != null) {
				Long beneficiaryRegID = obj.getLong("beneficiaryRegID");
				String s = commonDoctorServiceImpl.fetchBenPreviousSignificantFindings(beneficiaryRegID);
				if (s != null)
					response.setResponse(s);
				else
					response.setError(5000, "Error while fetching previous significant findings");
			} else {
				response.setError(5000, "Invalid data!");
			}
		} catch (Exception e) {
			// e.printStackTrace();
			logger.error("Error while fetching previous significant findings" + e);
			response.setError(e);
		}
		return response.toString();
	}
	
	@CrossOrigin()
	@ApiOperation(value = "Get Lab technician worklist new", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getLabWorklistNew" }, method = { RequestMethod.GET })
	public String getLabWorkListNew() {
		OutputResponse response = new OutputResponse();
		try {
			String s = commonNurseServiceImpl.getLabWorkListNew();
			if (s != null)
				response.setResponse(s);
			else
				response.setError(5000, "Error while fetching Lab worklist");
		} catch (Exception e) {
			// e.printStackTrace();
			logger.error("Error in getLabWorklist:" + e);
			response.setError(e);
		}
		return response.toString();
	}
	
	// Get radiologist worklist new
	@CrossOrigin()
	@ApiOperation(value = "Get radiologist worklist new", consumes = "application/json", produces = "application/json")
	@RequestMapping(value = { "/getRadiologist-worklist-New" }, method = { RequestMethod.GET })
	public String getRadiologistWorklistNew() {
		OutputResponse response = new OutputResponse();
		try {
			String s = commonNurseServiceImpl.getRadiologistWorkListNew();
			if (s != null)
				response.setResponse(s);
			else
				response.setError(5000, "Error while fetching radiologist worklist");
		} catch (Exception e) {
			// e.printStackTrace();
			logger.error("Error in getLabWorklist:" + e);
			response.setError(e);
		}
		return response.toString();
	}
	
	// Get oncologist worklist new
		@CrossOrigin()
		@ApiOperation(value = "Get oncologist worklist new", consumes = "application/json", produces = "application/json")
		@RequestMapping(value = { "/getOncologist-worklist-New" }, method = { RequestMethod.GET })
		public String getOncologistWorklistNew() {
			OutputResponse response = new OutputResponse();
			try {
				String s = commonNurseServiceImpl.getOncologistWorkListNew();
				if (s != null)
					response.setResponse(s);
				else
					response.setError(5000, "Error while fetching oncologist worklist");
			} catch (Exception e) {
				// e.printStackTrace();
				logger.error("Error in getLabWorklist:" + e);
				response.setError(e);
			}
			return response.toString();
		}
}
