package demo.base;

import com.github.javafaker.Faker;

public class Fakar_Random_Data 
{
 Faker faker=new Faker();
  
 public String getName()
 {
	 return faker.name().fullName();
 }
  
 public String getCity()
 {
	 return faker.address().city();
 }
 public String getCountry()
 {
	 return faker.address().country();
 }
 public String getCardNumber()
 {
	 return faker.finance().creditCard();
 }
 public String getMonth()
 {
	 return String.valueOf(faker.number().numberBetween(1, 12));
 }
 
 public String getYear()
 {
	 return  String.valueOf(faker.number().numberBetween(2025, 2030));
 }
}
