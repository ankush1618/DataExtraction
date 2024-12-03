package dataExtractionLayer;


import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class ExtractRegistrationAndHallTicket {

    List<String> datalist = new ArrayList<>();

    public void performExtraction(String applicationRequestText, String entranceExamName){

        try{
            // Split the input text by spaces to process each word separately

            String applicationRequest[] = applicationRequestText.split("\\s+");
            int applicationRequestLength= applicationRequest.length;
            String lastWord=applicationRequest[applicationRequestLength-1];

            // Remove the trailing period from the last word, if present
            if(lastWord.contains(".")){
                lastWord=lastWord.replace(".", "");
            }

            applicationRequest[applicationRequestLength-1]=lastWord;
            // Define regex patterns:
            // chregex - for alphabetic strings; regex - for alphanumeric strings
            String chregex =  "^[a-zA-Z]+$";
            String regex = "^[a-zA-Z0-9]+$";
            Pattern pattern = Pattern.compile(regex);
            Pattern chpattern= Pattern.compile(chregex);
            // Loop through each word to detect and add keywords and identifiers to datalist
            for (int i = 0; i < applicationRequestLength; i++) {
                switch (applicationRequest[i].toLowerCase()) {
                    case "registration":
                        // Add "registration" keyword to datalis
                        datalist.add(applicationRequest[i].toLowerCase());
                        break;
                    case "hall":
                        // Add "hall" keyword to datalist
                        datalist.add(applicationRequest[i].toLowerCase());
                        break;
                    case "application":
                        // Add "application" keyword to datalist
                        datalist.add(applicationRequest[i].toLowerCase());
                        break;
                }
                // Add alphanumeric values that aren't purely alphabetic to datalist
                if(pattern.matcher(applicationRequest[i]).matches() && !chpattern.matcher(applicationRequest[i]).matches()){
                    datalist.add(applicationRequest[i]);
                }
            }
            // Call the method to display extracted information
            displayRegistrationAndHallTicketNumbers(entranceExamName);
            // Clear datalist to prepare for the next input processing
            datalist.clear();
        }

        catch(Exception e){
            // Handle any exception that occurs during processing
            System.out.println("Exception is" +e);
        }
    }


    public void displayRegistrationAndHallTicketNumbers(String entranceExamName){

        try{
            // Various conditional checks based on specific patterns in the datalist
            // Each condition prints the extracted registration and hall ticket numbers
            if(datalist.get(0).equals("application") && datalist.get(1).equals("registration") && datalist.get(3).equals("hall")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(2)+" "+"and Hallticket Number is "+datalist.get(4));
            }

            else if(datalist.get(0).equals("application") && datalist.get(1).equals("hall") && datalist.get(3).equals("registration")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(4)+" "+"and Hallticket Number is "+datalist.get(2));
            }
            // Multiple other conditions follow the same logic pattern
            // They compare the structure of the datalist to match specific cases
            else if(datalist.get(0).equals("registration") && datalist.get(1).equals("application") && datalist.get(3).equals("hall")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(2)+" "+"and Hallticket Number is "+datalist.get(4));
            }

            else if(datalist.get(0).equals("registration") && datalist.get(1).equals("hall") && datalist.get(2).equals("application")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(3)+" "+"and Hallticket Number is "+datalist.get(4));
            }
            else if(datalist.get(0).equals("application") && datalist.get(1).equals("registration") && datalist.get(2).equals("hall")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(3)+" "+"and Hallticket Number is "+datalist.get(4));
            }
            else if(datalist.get(0).equals("application") && datalist.get(1).equals("hall") && datalist.get(2).equals("registration")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(4)+" "+"and Hallticket Number is "+datalist.get(3));
            }
            else if(datalist.get(0).equals("registration") && datalist.get(1).equals("hall") && !datalist.get(2).equals("application")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(2)+" "+"and Hallticket Number is "+datalist.get(3));
            }
            else if(datalist.get(0).equals("hall") && datalist.get(1).equals("registration") && !datalist.get(2).equals("application")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(3)+" "+"and Hallticket Number is "+datalist.get(2));
            }
            else if(datalist.get(0).equals("registration") && datalist.get(2).equals("hall") && !datalist.get(3).equals("application")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(1)+" "+"and Hallticket Number is "+datalist.get(3));
            }
            else if(datalist.get(0).equals("registration") && datalist.get(2).equals("hall") && datalist.get(3).equals("application")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(1)+" "+"and Hallticket Number is "+datalist.get(4));
            }
            else if(datalist.get(0).equals("hall") && datalist.get(2).equals("registration")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(3)+" "+"and Hallticket Number is "+datalist.get(1));
            }
            else if(datalist.get(0).equals("registration") && datalist.get(3).equals("hall") && !datalist.get(2).equals("application")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(1)+" "+"and Hallticket Number is "+datalist.get(2));
            }
            else if(datalist.get(0).equals("registration") && datalist.get(2).equals("hall") && datalist.get(3).equals("application")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(4)+" "+"and Hallticket Number is "+datalist.get(1));
            }
            else if(datalist.get(0).equals("hall") && datalist.get(3).equals("registration") && !datalist.get(2).equals("application")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(2)+" "+"and Hallticket Number is "+datalist.get(1));
            }
            else if(datalist.get(0).equals("hall") && datalist.get(2).equals("application") && datalist.get(3).equals("registration")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(4)+" "+"and Hallticket Number is "+datalist.get(1));
            }
            else if(datalist.get(0).equals("application") && datalist.get(3).equals("hall") && !datalist.get(2).equals("registration")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(1)+" "+"and Hallticket Number is "+datalist.get(2));
            }
            else if(datalist.get(0).equals("hall") && datalist.get(3).equals("application") && !datalist.get(2).equals("registration")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(2)+" "+"and Hallticket Number is "+datalist.get(1));
            }
            else if(datalist.get(0).equals("application") && datalist.get(2).equals("hall") && !datalist.get(1).equals("registration")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(1)+" "+"and Hallticket Number is "+datalist.get(3));
            }
            else if(datalist.get(0).equals("application") && datalist.get(2).equals("registration") && datalist.get(3).equals("hall")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(1)+" "+"and Hallticket Number is "+datalist.get(4));
            }
            else if(datalist.get(0).equals("hall") && datalist.get(2).equals("application") && !datalist.get(3).equals("registration")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(3)+" "+"and Hallticket Number is "+datalist.get(1));
            }
            else if(datalist.get(0).equals("registration") && datalist.get(1).equals("hall") && !datalist.get(2).equals("application")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(2)+" "+"and Hallticket Number is "+datalist.get(3));
            }
            else if(datalist.get(0).equals("hall") && datalist.get(1).equals("registration") && !datalist.get(2).equals("application")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(3)+" "+"and Hallticket Number is "+datalist.get(2));
            }
            else if(datalist.get(0).equals("application") && datalist.get(1).equals("hall") && !datalist.get(2).equals("registration") && !datalist.get(3).equals("registration")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(2)+" "+"and Hallticket Number is "+datalist.get(3));
            }
            else if(datalist.get(0).equals("application") && datalist.get(1).equals("hall") && datalist.get(2).equals("registration") && !datalist.get(3).equals("registration")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(4)+" "+"and Hallticket Number is "+datalist.get(3));
            }
            else if(datalist.get(0).equals("hall") && (datalist.get(1).equals("application") ||datalist.get(1).equals("registration")) && !datalist.get(2).equals("registration") && !datalist.get(3).equals("registration")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(3)+" "+"and Hallticket Number is "+datalist.get(2));
            }
            else if((datalist.get(2).equals("application")) && datalist.get(3).equals("hall") && !datalist.get(0).equals("registration")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(0)+" "+"and Hallticket Number is "+datalist.get(1));
            }
            else if(datalist.get(0).equals("registration") && datalist.get(2).equals("application") && datalist.get(3).equals("hall")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(1)+" "+"and Hallticket Number is "+datalist.get(4));
            }
            else if(datalist.get(0).equals("registration") && datalist.get(2).equals("application") && datalist.get(4).equals("hall")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(1)+" "+"and Hallticket Number is "+datalist.get(3));
            }
            else if((datalist.get(3).equals("application") || datalist.get(3).equals("registration")) && datalist.get(4).equals("hall")){
                System.out.println(entranceExamName+ ":"+" " +"Registration Number is "+datalist.get(1)+" "+"and Hallticket Number is "+datalist.get(3));
            }
            else{
                // This "else" condition handles rejected cases
                System.out.println("Sorry! Your application has been rejected");
            }
        }

        catch(Exception e){
            System.out.println("Exception is" +e);
        }
    }




    public static void main(String[] args) {
        // Process the three provided inputs for extraction and display
        ExtractRegistrationAndHallTicket extract= new ExtractRegistrationAndHallTicket();
        extract.performExtraction(DataResource.JEE_ENTRANCE_APPLICATION_TEXT,DataResource.JEE_ENTRANCE);
        extract.performExtraction(DataResource.NEET_ENTRANCE_APPLICATION_TEXT,DataResource.NEET_ENTRANCE);
        extract.performExtraction(DataResource.BANK_ENTRANCE_APPLICATION_TEXT,DataResource.BANK_ENTRANCE);

    }


}
