import java.util.*;
public class leaky
{
 public static void main(String[] ar)
 {
  Scanner my =new Scanner(System.in);
  int no_group,bucket_size;
  //user input
  System.out.println("enter The bucket size");
  bucket_size = my.nextInt();
  System.out.print("Enter the no.of group");
  no_group = my.nextInt();
  //decaler varible
  int no_packet[] = new int[no_group];
  int in_bw[] = new int[no_group];
  int out_bw,reqd_bw=0,tot_packet=0;
  
  for(int i=0;i<no_group;i++)
  {
    System.out.println("Enter the no.of packets for each group" + (i+1) + "\t");
    no_packet[i] = my.nextInt();
    System.out.print("Enter the input bandwidth for each group" + (i+1) + "\t" );
    in_bw[i] = my.nextInt();
    
    if((tot_packet+ no_packet[i])<=bucket_size)
    {
     tot_packet += no_packet[i];
    }
    else
    {
     do
     {
      System.out.println("bucket overfall");
      System.out.println("Enter the value less than" + (bucket_size - tot_packet));
      no_packet[i] = my.nextInt();
     }
     while((tot_packet + no_packet[i])>bucket_size);
    tot_packet +=no_packet[i];
   }
   reqd_bw+= (no_packet[i]*in_bw[i]);
  }
  System.out.println("The total reqder bandwidthis" + reqd_bw);
  System.out.println("Enter the output bandwidth");
  out_bw = my.nextInt();
  int temp = reqd_bw;
  int rem_pkts = tot_packet;
  
  while((out_bw<=temp)&&(rem_pkts>0))
  {
   System.out.println("data Sent " + (--rem_pkts) + "packets remaining");
   System.out.println("remaining bandwidth " + (temp -=out_bw));
   if((out_bw>temp)&&(rem_pkts>0))
     System.out.print(rem_pkts+"fuck you");
   }
 }
}
    
    

  
  
