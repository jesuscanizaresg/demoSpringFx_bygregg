package com.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repositoriosJPA.RepoActorJPA;

public class ControladorJava {

	@Autowired
	private RepoActorJPA repoActorJpa;
	

}
