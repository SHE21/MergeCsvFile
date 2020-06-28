package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class MyBufferReader {

	private String dirFile;

	public MyBufferReader(String dirFile) {
		this.dirFile = dirFile;
	}

	public BufferedReader getBufferReader() {
		try {
			BufferedReader lerArq = new BufferedReader(new InputStreamReader(new FileInputStream(this.dirFile), "UTF-8"));

			return lerArq;

		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
			return null;
		}
	}
	
	public static String resultFromCompare(List<DataFilds> dataBase, List<DataFilds> dataCompared) throws IOException {
		String result = "";
		
		for(int i= 0; i <dataBase.size();i++) {
			DataFilds dataFildsBase = dataBase.get(i);
			
			result += dataFildsBase.fildOne +";"+ dataFildsBase.fildTwo+";"+compare(dataFildsBase.fildTwo, dataCompared)+"\n";
		}
		
		return result;
	}
	
	public static String compare(String str, List<DataFilds> dataCompared) throws IOException {
		String result = null;
		
		for(int j= 0; j <dataCompared.size();j++) {
			
			DataFilds dataFilds = dataCompared.get(j);
			
			if(dataFilds.fildTwo.equals(str)){
				return dataFilds.fildThree+ ";" + dataFilds.fildFour;
				
			}else {
				result = "0;0;";
			}
		}
		
		return result;
	}
	
	//
	public static List<DataFilds> getListData(String file) throws IOException {

		BufferedReader buffer = getBuffer(file);
		String linha = buffer.readLine();

		List<DataFilds> lista = new ArrayList<>();

		try {

			while(linha != null) {
				
				String[] data = linha.split(";");
				if(data.length==4) {
					lista.add(new DataFilds(data[0], data[1], data[2], data[3]));
					
				}else {
					lista.add(new DataFilds(data[0], data[1], null, null));
				}

				linha = buffer.readLine();
			}

			buffer.close();

			return lista;

		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
			return null;
		}
	}
	
	public static void outFinalFile(String dirOut, String data) throws IOException {
		OutputStreamWriter bufferOut = new OutputStreamWriter(
                new FileOutputStream(dirOut),"UTF-8");
		
		bufferOut.write(data);
		
		bufferOut.close();
	}
	
	public static BufferedReader getBuffer(String file) {
		MyBufferReader my = new MyBufferReader(file);
		return my.getBufferReader();
	}
}





