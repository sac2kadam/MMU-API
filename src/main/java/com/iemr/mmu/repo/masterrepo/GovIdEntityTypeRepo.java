package com.iemr.mmu.repo.masterrepo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.mmu.data.masterdata.GovIdEntityType;

@Repository
public interface GovIdEntityTypeRepo extends CrudRepository<GovIdEntityType, Short> {
	@Query(" select govtIdentityTypeID, identityType from GovIdEntityType where  deleted = false order by identityType ")
	public ArrayList<Object[]> getGovIdEntityMaster();
}
