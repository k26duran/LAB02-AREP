/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App 
{
    
    /** Method to calculate the mean of the data in linkedList
	 *@param list linkedList
	 *@return the value of mean**/
	public double mean(LinkedList list) 
	{ 
		Node actualNode = list.getHead(); 
		double result=0; 
		int tam=0; 
		while (actualNode != null) { 
			result += actualNode.getData() ; 
			tam += 1;
			actualNode = actualNode.getNext(); 
		} 
		return roundNumber(result/tam,2); 
	}
	
	/** Method to round decimals
	 * @param initValue the number to round
	 * @param n the number of position to round
	 * @return rounded number**/
	public double roundNumber(double initValue, int n) {
        double intPart, result;
        result = initValue;
        intPart = Math.floor(result);
        result=(result-intPart)*Math.pow(10, n);
        result=Math.round(result);
        result=(result/Math.pow(10, n))+intPart;
        return result;
    }
	
	/** Method to calculate the standard desviation of the data in linkedList
	 * @param list linkedList
	 * @return the result of calculate standard desviation**/
	public double standardDesviation(LinkedList list) 
		{ 
			Node currNode = list.getHead(); 
			double result=0; 
			int tam=-1;
			double mean= mean(list);
			while (currNode != null) { 
				result += Math.pow(currNode.getData() - mean,2); 
				tam += 1;
				currNode = currNode.getNext(); 
			} 
			return roundNumber(Math.pow(result/tam,0.5),2); 
		} 

		/**Method to read data from a file
	 * @param file the path of the file with numbers
	 * @param list an empty linkedList
	 * @throws FileNotFoundException when the file does not exist
	 * @throws IOException when an I/O error occurs
	 * @return the linkedList with the values from the file**/
	public LinkedList readData(String file) throws FileNotFoundException, IOException {
		LinkedList list = new LinkedList(); 
        String c;
        FileReader f = new FileReader(file);
        BufferedReader b = new BufferedReader(f);
        while((c = b.readLine())!=null) {
        	list= list.insert(list, Double.parseDouble(c));
            //System.out.println(c);
        }
        b.close();
        return list;
    }
        /**
	public static void main(String[] args) throws IOException { 
		
		LinkedList list = new LinkedList(); 
		
		list=readData("prueba.txt");
		
		// Print the LinkedList 
		list.printList(list); 
		System.out.println("Mean: " + mean(list));
		System.out.println("Standard desviation: " + standardDesviation(list));
		
	}**/
}