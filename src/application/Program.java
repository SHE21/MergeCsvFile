package application;

import java.io.IOException;
import java.util.List;

public class Program{

	public static void main(String[] args) throws IOException {
		//file with the data to be extracted and added to the base file
		final String FILE_DATA_COMPARETED = "C:\\wamp64\\www\\processDataCovid\\data.csv";
		//merge target file
		final String FILE_DATA_BASE = "C:\\wamp64\\www\\processDataCovid\\data_base.csv";
		
		//directory where the new file will be saved
		final String FILE_DATA_SAVED = "C:\\\\wamp64\\\\www\\\\processDataCovid\\\\ouTeste.csv";
		
		//List<DataFilds> from file FILE_DATA_BASE
		List<DataFilds> dataBase = MyBufferReader.getListData(FILE_DATA_BASE);
		
		//List<DataFilds> from FILE_DATA_COMPARETED
		List<DataFilds> dataCompared = MyBufferReader.getListData(FILE_DATA_COMPARETED);
		
		//merge result between two files
		String resultFromCompare = MyBufferReader.resultFromCompare(dataBase,dataCompared);
		
		MyBufferReader.outFinalFile(FILE_DATA_SAVED, resultFromCompare);
		
		System.out.println(resultFromCompare);
	}
}
