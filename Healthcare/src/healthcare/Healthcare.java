
package healthcare;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class Healthcare {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/health","root","kumar");
            Statement stmt = con.createStatement();
            Scanner sc=new Scanner(System.in);
            System.out.println("---------------------Welcome to HealthCare-Management department--------------------------");
            System.out.println("1.Admin-login");
            System.out.println("2.Doctor-login");
            System.out.println("3.Patient-login");
            int count=1;
            boolean one,two,three;
            for(int i=0;i<count;i++)
            {
                System.out.println("Enter the vaild number :");
                int choose=sc.nextInt();
                if(choose==1 || choose==2 || choose==3|| choose==4)
                {
                    switch(choose)
                    {
                        case 1:
                            System.out.println("1.-----welcome to admin panel");
                          
                            System.out.println("11.DoctorList");
                            System.out.println("12.ADDdoctor");
                            System.out.println("13.Removedoctor");
                            System.out.println("14.ViewFeedback");
                            int count1=1;
                            for(int j=0;j<count1;j++)
                            {
                                System.out.println("Enter the vaild number for admin panel1");
                                int num1=sc.nextInt();
                                if(num1==11|| num1==12||num1==13||num1==14)
                                {
                                    switch(num1)
                                    {
                                        case 11:
                                            System.out.println("------------Doctor list------------");
                                            String query="select * from adddoctor";
                                            ResultSet res=stmt.executeQuery(query);
                                            while(res.next())
                                            {
                                                int id = res.getInt("doc_id"); 
                                                String name = res.getString("doc_name");
                                                int age = res.getInt("doc_age");
                                                String gender = res.getString("doc_gender");
                                                String department = res.getString("doc_dept");
                                                int phone = res.getInt("doc_phone");

          
                                                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + 
                                                                   ", Gender: " + gender + ", Department: " + department + 
                                                                   ", Phone: " + phone);
                                            }
                                            
                                            break;
                                        case 12:
                                            System.out.println("--------------Enter the doctor List----------------- ");
                           
                                     
                                                System.out.println("Enter the id");
                                                int doc_id=sc.nextInt();
                                                
                                                System.out.println("Enter the name");
                                                String doc_name=sc.next();
                                                
                                                System.out.println("Enter the age");
                                                int doc_age=sc.nextInt(); 
                                                
                                                System.out.println("Enter the gender");
                                                String doc_gender=sc.next();
                                                
                                                System.out.println("Enter the department");
                                                String doc_dept=sc.next();
                                                
                                                System.out.println("Enter the phone");
                                                int doc_phone=sc.nextInt();
                                                
                                                String sql = "INSERT INTO adddoctor (doc_id, doc_name, doc_age, doc_gender, doc_dept, doc_phone) VALUES (" 
                                                + doc_id + ", '" + doc_name + "', " + doc_age + ", '" + doc_gender + "', '" 
                                                + doc_dept + "', '" + doc_phone + "')";
            
         
                                               
                                                stmt.executeUpdate(sql);
                                    
                                            break;
                                        case 13:
                                            System.out.println("-------------Remove doctor from list--------------");
                                            System.out.println("To enter the name to want remove");
                                            String remove=sc.next();
                                            
                                            String query1="delete from adddoctor where doc_name='"+remove+"'";
                                            stmt.executeUpdate(query1);
                                            break;
                                        case 14:
                                            System.out.println("-------------ViewFeedback----------------");
                                            String query2="select * from feeback";
                                            ResultSet res1=stmt.executeQuery(query2);
                                            while(res1.next())
                                            {
                                                int id = res1.getInt("feed_id"); 
                                                int userid = res1.getInt("user_id");
                                                String infor = res1.getString("feed_infor");
                                                int rating = res1.getInt("feed_rating");
                                                

          
                                                System.out.println("ID: " + id +  ", user_id: " + userid + 
                                                                   ", Information: " + infor + ", rating: " + rating);
                                            }
                                            
                                            break;

                                    }
                                }
                                else
                                {
                                   System.out.println("Enter the value correctly");  
                                }
                                System.out.println("Are you want to continue please enter true");
                                one=sc.nextBoolean();
                                if(one==true)
                                    count1++;
                                else
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("-----welcome to doctor panel-----------------");
                            System.out.println("21.View appointments");
                            int count3=1;
                            for(int j=0;j<count3;j++)
                            {
                               System.out.println("Enter the vaild number for doctor panel1");
                                int num1=sc.nextInt();
                                if(num1==21)
                                { 
                                    
                                    switch(num1)
                                    {
                                        case 21:
                                            String query3="select * from appointment";
                                             ResultSet res = stmt.executeQuery(query3);
                                             while (res.next()) {                                           
                                                int app_id = res.getInt("app_id");          
                                                String app_name = res.getString("app_name"); 
                                                String doc_name = res.getString("doc_name"); 
                                                String app_date = res.getString("app_date"); 
                                                String app_problem = res.getString("app_problem");

                                         
                                            System.out.println("App ID: " + app_id + ", App Name: " + app_name + 
                                                               ", Doctor Name: " + doc_name + ", Date: " + app_date + 
                                                               ", Problem: " + app_problem);
                                                     }
                                             break;
                                    }

                                }
                                 else
                                {
                                   System.out.println("Enter the value correctly");  
                                }
                                System.out.println("Are you want to continue please enter true");
                                three=sc.nextBoolean();
                                if(three==true)
                                    count3++;
                                else
                                    break;   
                                
                            }
                            break;
                        case 3:
                            System.out.println("-----welcome to patient panel----------");
                            System.out.println("31.ADDprofile");
                            System.out.println("32.View doctor");
                            System.out.println("33.Appointment Booking");
                            System.out.println("34.Give feedback");
                            int count2=1;
                            for(int j=0;j<count2;j++)
                            {
                                System.out.println("Enter the vaild number for patient panel1");
                                int num1=sc.nextInt();
                                if(num1==31|| num1==32||num1==33||num1==34)
                                {
                                    switch(num1)
                                    {
                                        case 31:
                                            System.out.println("------------------------Enter the patient profile---------------------------");
                                                System.out.println("Enter the id");
                                                int use_id=sc.nextInt();
                                                
                                                System.out.println("Enter the name");
                                                String use_name=sc.next();
                                                
                                                System.out.println("Enter the gender");
                                                String use_gender=sc.next();
                                                
                                                System.out.println("Enter the age");
                                                int use_age=sc.nextInt();
                                                
                                                System.out.println("Enter the address");
                                                String use_address=sc.next();
                                                
                                                System.out.println("Enter the problem");
                                                String use_problem=sc.next();
                                                
                                                String sql = "INSERT INTO addprofile (use_id, use_name, use_gender, use_age, use_address, use_problem) VALUES (" 
                                                + use_id + ", '" + use_name + "', '" + use_gender + "', " + use_age + ", '" 
                                                + use_address + "', '" + use_problem + "')";
                                                
                                                stmt.executeUpdate(sql);
                                            break;
                                        case 32:
                                            System.out.println("--------------------------View doctors----------------------------");
                                            String query="select * from adddoctor";
                                            ResultSet res=stmt.executeQuery(query);
                                            while(res.next())
                                            {
                                                int id = res.getInt("doc_id"); 
                                                String name = res.getString("doc_name");
                                                int age = res.getInt("doc_age");
                                                String gender = res.getString("doc_gender");
                                                String department = res.getString("doc_dept");
                                                int phone = res.getInt("doc_phone");

          
                                                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + 
                                                                   ", Gender: " + gender + ", Department: " + department + 
                                                                   ", Phone: " + phone);
                                            }
                                            break;
                                        case 33:
                                            System.out.println("------------------------Appointment Booking---------------------");
                                                System.out.println("Enter the id");
                                                int app_id=sc.nextInt();
                                                
                                                System.out.println("Enter the name");
                                                String app_name=sc.next();
                                                        
                                                System.out.println("Enter the doctor name");
                                                String doc_name=sc.next();
                                                
                                                System.out.println("Enter the date");
                                                String app_date=sc.next();
                                                
                                                 System.out.println("Enter the problem");
                                                String app_proble=sc.next();
                                                
                                                String sql3 = "INSERT INTO appointment (app_id, app_name, doc_name, app_date, app_proble) VALUES (" 
                                                + app_id + ", '" + app_name + "', '" + doc_name + "', '" + app_date + "', '" + app_proble + "')";
                                                stmt.executeUpdate(sql3);
                                            break;
                                            
                                        case 34:
                                            System.out.println("--------------------------Enter the FeedBack-------------------------");
                                                System.out.println("Enter the id");
                                                int feed_id=sc.nextInt();
                                                
                                                System.out.println("Enter the user id");
                                                int user_id=sc.nextInt();
                                                        
                                                System.out.println("Enter the Experience");
                                                String feed_infor=sc.next();
                                                
                                                System.out.println("Enter the rating");
                                                int feed_rating=sc.nextInt();
                                                
                                                String sql2 = "INSERT INTO feeback (feed_id, user_id, feed_infor, feed_rating) VALUES (" 
                                                + feed_id + ", '" + user_id +  "', '" + feed_infor  + "', '" + feed_rating + "')";
                                                stmt.executeUpdate(sql2);
                                                break;
                                    }
                                }
                                else
                                {
                                   System.out.println("Enter the value correctly");  
                                }
                                System.out.println("Are you want to continue please enter true");
                                two=sc.nextBoolean();
                                if(two==true)
                                    count2++;
                                else
                                    break;
                            }
                                   
                            break;


                    }
                }
                else
                {
                    System.out.println("Enter the value correctly");
                }
                System.out.println(" Finally are you want to continue please enter true");
                boolean continues=sc.nextBoolean();
                if(continues==true)
                    count++;
                else
                {
                    System.out.println("Thank you for visting us");
                }
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Healthcare.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Healthcare.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
