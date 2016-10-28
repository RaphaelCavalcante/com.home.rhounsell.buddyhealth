package com.home.rhounsell.buddyhealth;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.home.rhounsell.buddyhealth.controller.OwnerController;
import com.home.rhounsell.buddyhealth.controller.PetController;

public class BuddyHealthBinder extends AbstractBinder{

	@Override
	protected void configure() {
		bind(OwnerController.class).to(OwnerController.class);
		bind(PetController.class).to(PetController.class);
	}

}
