import java.io.*;
class crc
{
 static int[] computecrc(int app_message[],int gen[],int rem[])
  {
    int current = 0;
    while(true)
    {
     for(int i=0;i<gen.length;i++)
        rem[current +i] = (int)(rem[current+i]^gen[i]);
     while(rem[current]==0 && current!=rem.length-1)
				current++; 
      if((rem.length-current)<gen.length)
         break;
    }
     return rem;
  }
 public static void main(String[] ar) throws IOException
{
  InputStreamReader isr = new InputStreamReader(System.in);
  BufferedReader br = new BufferedReader(isr);
  int[] message;
  int[] gen;
  int[] app_message;
  int[] rem;
  int[] trans_message;
  int message_bits,gen_bits,total_bits;
  
  System.out.print("\n Enter the no.of bits in msg");
  message_bits = Integer.parseInt(br.readLine());
  message = new int[message_bits];

  System.out.println("Enterthe msg bits");
  for(int i=0;i<message_bits;i++)
     message[i] = Integer.parseInt(br.readLine());

  System.out.print("enter the no.of bits in gen");
  gen_bits = Integer.parseInt(br.readLine());
  gen = new int[gen_bits];

  System.out.println("Enter the gen bits");
  for(int i=0;i<gen_bits;i++)
	    gen[i] = Integer.parseInt(br.readLine());
	    total_bits= message_bits+gen_bits-1;
	    app_message=new int[total_bits];
            rem = new int[total_bits];
	    trans_message= new int[total_bits];
  
 for(int i=0;i<message.length;i++)
        app_message[i] = message[i];
	System.out.print("Msg bit are ");
 	for(int i=0;i<message_bits;i++)
   		 System.out.print(message[i]);
 		 System.out.print("Gen bit are ");
 for(int i=0;i<gen_bits;i++)
    System.out.print(gen[i]);
 System.out.print("Append msg is ");
 for(int i=0;i<app_message.length;i++)
    System.out.print(app_message[i]);
 for(int j=0;j<app_message.length;j++)
    rem[j] = app_message[j];
 rem=computecrc(app_message,gen,rem);
 for(int i=0;i<app_message.length;i++)
     trans_message[i]=(app_message[i]^rem[i]);
 System.out.print("trans message from the transmittor");
 for(int i=0;i<trans_message.length;i++)
     System.out.print(trans_message[i]);
 System.out.println("\nenter msg of" + total_bits + "bits received");
 for(int i=0;i<trans_message.length;i++)
    trans_message[i] = Integer.parseInt(br.readLine());
 System.out.println("Received msg is");
 for(int i=0;i<trans_message.length;i++)
    System.out.print(trans_message[i]);
 for(int j=0;j<trans_message.length;j++)
    rem[j]=trans_message[j];
 rem = computecrc(trans_message,gen,rem);
 for(int i=0;i<rem.length;i++)
 {
    if(rem[i]!=0)
    {
     System.out.println("there is a error");
     break;
    }
     if(i==rem.length-1)
     {
      System.out.println("noError");
     }
   }
  
}
  
}


 
