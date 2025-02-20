package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Product{

	private static BufferedReader br;
	
	private String genre;
	private String name;
	private String artist;
	private int id;
	
	public Product(String str) {
		this.parse(str);
	}
	
	public static void initTableScan(String fileName) throws IOException{
		closeTableScan();
		
		File f = new File(fileName);
		if(f.exists()){
			br = new BufferedReader(new FileReader(f));
		}
	}
	
	public static Product fetchNext() throws IOException{
		if (br.ready()) {
		  String line = br.readLine();
		  return new Product(line);
		}
		
		return null;
	}
	
	public static void closeTableScan() throws IOException{
		if(br != null)
			br.close();
	}
	
	public void parse(String str){
		String[] tokens = str.split(", ");
		if(tokens.length > 1){
			this.genre = tokens[0].replaceAll("\"", "");;
		}
		
		if(tokens.length > 2){
			this.name = tokens[1].replaceAll("\"", "");;
		}
		
		if(tokens.length > 3){
			this.artist = tokens[2].replaceAll("\"", "");;
		}
		
		this.id = Integer.parseInt(tokens[tokens.length - 1]);
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return this.id + "\t| " + this.name + "\t| " + this.artist + "\t| " + this.genre;
	}

}
