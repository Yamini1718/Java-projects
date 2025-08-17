package day17;



	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;

	public class ReadandReverse {
	    public static void main(String[] args) {
	        String filePath = "C:\\Users\\yamin\\FileHandling\\file.txt";
	        try {
	            FileReader reader = new FileReader(filePath);
	            StringBuilder content = new StringBuilder();
	            int ch;
	            while ((ch = reader.read()) != -1) {
	                content.append((char) ch);
	            }
	            reader.close();

	            String reversed = content.reverse().toString();

	            FileWriter writer = new FileWriter(filePath);
	            writer.write(reversed);
	            writer.close();

	            System.out.println("File content reversed successfully!");
	        } catch (IOException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	}

