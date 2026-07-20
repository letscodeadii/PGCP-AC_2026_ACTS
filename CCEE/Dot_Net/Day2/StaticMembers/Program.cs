using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http.Headers;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Text;
using System.Threading.Tasks;

namespace StaticMembers
{
    class Program
    {
        static void Main()
        {
            Class1 o1;
            o1=new Class1();

            Console.WriteLine(Class1.static_i);
            Class1.static_i = 1000;
            Class1.static_Display();
            Class1.P2=100;
            o1.i = 100;
            o1.Display();
            Class1 o2 = new Class1();
            o2.i = 200;
            //Console.BackgroundColor = ConsoleColor.Red;

            Console.ReadLine();




         


        }
    }
    public class Class1
    {
        static Class1()
        {
            Console.WriteLine("static constructor called");
            static_i = 1000;

        }
        public int i;
        //static variable - why ?-single copy for the class
        public static int static_i;


        public void Display()
        {
            //Console.WriteLine(i);
            //Console.WriteLine(static_i);
            Console.WriteLine("Display");
        }
        //static function ? -- can be called directly classname.methodname without creating an object 
        public static void static_Display()
        {
            //Console.WriteLine(i);
            Console.WriteLine(static_i);
            Console.WriteLine("Static Display");
        }

        private static int p2;
        public static int P2
        {
            set
            {
                p2 = value;
            }
            get
            {
                return p2;
            }
        }
    }
}
//why static variable ?-> single copy 
//why property ? -> validation 

//why static property ? -> single copy with validation 
//Why constructor --> to intialize data members
//Why static constructor -> to initilaize static members 

//when is the static constructor called ? -> When the class is loaded 
//When the class loaded ? -> When the first object is created
//                                             OR When a static member is accessed for the first time 

//static constant is implicitly called 
//static constant cant have parameters
//static constant cannot be overloaded 
//static constant does not have any access specifiers(implicitly private) 

//TO DO 
//static class
//can only have static memebers
//cannot create an object of the static class
//cannot be used as a base class



