package br.edu.ifpb.dac.gerenciadorSenha.presentation.dto;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.gerenciadorSenha.model.entity.Data;
import br.edu.ifpb.dac.gerenciadorSenha.model.entity.User;
@Service
public class ConverterDTO {
	
	public User dtoToUser(UserDTO userdto) {
		return new User(userdto.getName(),userdto.getPassword(), userdto.getLogin(),userdto.getTelephone(), userdto.getDataService());
	}
	public UserDTO userToDto(User user) {
		return new UserDTO(user.getName(),user.getPassword(), user.getLogin(),user.getTelephone(), user.getDataService());
	}
	public UserDTO userToDtoNoData(User user) {
		return new UserDTO(user.getName(),user.getPassword(), user.getLogin(),user.getTelephone(), null);
	}
	public Data dtoToData(DataDTO datadto) {
		Data d = new Data(datadto.getNameService(), datadto.getPassword(), datadto.getEmail(), datadto.getObservation());
		d.setId(datadto.getId());
		return d;
	}
	public DataDTO dataToDto(Data data) {
		DataDTO d = new DataDTO(data.getNameService(), data.getPassword(), data.getEmail(), data.getObservation());
		d.setId(data.getId());
		return d;
		
	}
	
	public  Set<Data> dtoToDataAll(Set<DataDTO> datadto) {
		  Set<Data> data = new HashSet<>();
		  
		  for(DataDTO d: datadto) {
			 data.add(dtoToData(d));
		  }
		  
		return data;
	}
	public  Set<User> dtoToUserAll(Set<UserDTO> userdto) {
		  Set<User> user = new HashSet<>();
		  
		  for(UserDTO u: userdto) {
			  user.add(dtoToUser(u));
		  }
		  
		return user;
	}
	
	public  Set<DataDTO> dataToDtoAll(Set<Data> dat) {
		  Set<DataDTO> data = new HashSet<>();
		  
		  for(Data d: dat) {
			 data.add(dataToDto(d));
		  }
		  
		return data;
	}
	public  Set<UserDTO> userToDtoAll(Set<User> u1) {
		  Set<UserDTO> user = new HashSet<>();
		  
		  for(User u: u1) {
			  user.add(userToDto(u));
		  }
		  
		return user;
	}

}
