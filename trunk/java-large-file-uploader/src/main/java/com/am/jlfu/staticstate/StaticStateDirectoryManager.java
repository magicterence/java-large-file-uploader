package com.am.jlfu.staticstate;


import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;





@Component
public class StaticStateDirectoryManager {

	@Autowired
	StaticStateRootFolderProvider staticStateRootFolderProvider;

	@Autowired
	StaticStateIdentifierManager staticStateCookieManager;



	/**
	 * Retrieves the file parent of the session.
	 * 
	 * @return
	 */
	public File getUUIDFileParent() {
		String uuid = staticStateCookieManager.getIdentifier();
		File uuidFileParent = new File(staticStateRootFolderProvider.getRootFolder(), uuid);
		if (!uuidFileParent.exists()) {
			uuidFileParent.mkdirs();
		}
		return uuidFileParent;
	}


}
