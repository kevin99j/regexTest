package com.venko.test.regex;

import com.venko.test.regex.utils.Reader;
import com.venko.test.regex.utils.RegexSolver;
import com.venko.test.regex.utils.Respuesta;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class RegexApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(RegexApplication.class, args);
		String filename = "assets/coronavirus.html";
		String finalFile = "assets/test.txt";
		String finalFile2 = "assets/response.txt";
	  	String fileResult =Reader.textReader(filename);

	 	List<Respuesta> respuestaList =	RegexSolver.regexSolver(fileResult);

	 	respuestaList.sort(new Comparator<Respuesta>() {
			@Override
			public int compare(Respuesta o1, Respuesta o2) {
				int res = o1.getMunicipio().compareTo(o2.getMunicipio());
				if ( res != 0){
					return res;
				} else {
					res = o1.getGenero().compareTo(o2.getGenero());
					if( res != 0){
						return res;
					} else {
						res = o1.getEdad().compareTo(o2.getEdad());
						if(res == 0 ){
							System.out.println("Repetidos...");
						}
						return res;
					}
				}
			}
		});

		respuestaList.forEach((respuesta -> {
			try {
				Reader.textWriter(respuesta.getMunicipio()+","+respuesta.getGenero()+","+respuesta.getEdad(),finalFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}));




	}

}
