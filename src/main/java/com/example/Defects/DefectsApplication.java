package com.example.Defects;

import java.util.ArrayList;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cmserver.ar.Defects;
import com.cmserver.ar.Reader;
import com.cmserver.ar.Writer;
import com.example.Defects.domain.App;
import com.example.Defects.domain.AppRepository;
import com.example.Defects.domain.Defect;
import com.example.Defects.domain.DefectInstance;
import com.example.Defects.domain.DefectRepository;
import com.example.Defects.domain.Defect_InstanceRepository;
import com.example.Defects.domain.LogFile;
import com.example.Defects.domain.LogFileRepository;
import com.example.Defects.domain.Solutions;
import com.example.Defects.domain.SolutionsRepository;

@SpringBootApplication
public class DefectsApplication {
	@Autowired
	private AppRepository apprepository;
	@Autowired
	private DefectRepository defrepository;
	@Autowired
	private LogFileRepository logrepository;
	@Autowired 
	private Defect_InstanceRepository DIrepository;
	@Autowired 
	private SolutionsRepository solrepository;
	private static ArrayList<Defects> defectsList;

	public static void main(String[] args) {
		SpringApplication.run(DefectsApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {

		return args -> {
			int i;
			int j=0;
			Solutions solu1 = new Solutions("solution 1","desc");
			solrepository.save(solu1);
			Solutions solu2 = new Solutions("solution 2","desc");
			solrepository.save(solu2);
			String[] s= {"CMServer.20170924_1557.log","111.log","ARServer.20181219_0638.log","CMServer.20181217_0617.log.65"};
			int numberOfLogs=s.length;
			for(int k=0;k<numberOfLogs;k++)
			{
				Date date = new Date();
				LogFile logfile= new LogFile(s[k],date);
				logrepository.save(logfile);
				Writer writer = Reader.extracted(s[k]);
				defectsList = writer.getDefectsList();
				for(Defects defect : defectsList ) 
				{

					i=defect.getApp().indexOf(" ");

					App app = new App(defect.getApp().substring(0, i),defect.getApp().substring(i+1,(defect.getApp().length()) ));
					apprepository.save(app);

					if(defect.getSeverity()!="error") {
						Defect d = new Defect(defect.getSeverity(),defect.getCode(),"j",solu1);		
						defrepository.save(d);	
						DefectInstance DI = new DefectInstance(  j++,  app,d,logfile);
						DIrepository.save(DI);

					}else		
					{	
						Defect d = new Defect(defect.getSeverity(),defect.getCode(),"j",solu2);
						defrepository.save(d);	
						DefectInstance DI = new DefectInstance( j++,  app,d,logfile);
						DIrepository.save(DI);
					}

				


				}	}


		};
	}



	//public	void fun() {
	//		
	//		
	//		
	//		String[] s= {"CMServer.20170924_1557.log","CMServer.20170914_2028.log"};
	//		int numberOfLogs=s.length;
	//		for(int k=0;k<numberOfLogs;k++)
	//		{
	//			Date date = new Date();
	//			LogFile logfile= new LogFile(s[k],date);
	//			logrepository.save(logfile);
	//			Writer writer = Reader.extracted(s[k]);
	//			defectsList = writer.getDefectsList();
	//		}
	//		
	//	
	//	}

}
