using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IDisposableExample
{
    class Program
    {
        static void Main1()
        {
            Class1 o = new Class1();
            o.Display();
            o.Dispose();
            o.Display();

            Console.ReadLine();
        }
        static void Main2()
        {
            using (Class1 o=new Class1())
            {
                o.Display();
            }
            Console.ReadLine();
        }

        static void Main()
        {
            class2 o = new class2();
            o.Display();
            o.Dispose();
            o.Display();

            Console.ReadLine();
        }
    }

    public class Class1 : IDisposable
    {
        public Class1()
        {
            //open file here 
            //open db here 
            Console.WriteLine("class1 constructor");
        }
        public void Display()
        {
            Console.WriteLine("Display Called");
        }
        public void Dispose()
        {
            //close file
            //close db 
            Console.WriteLine("Dispose code called . Write code here instead of Destructor ");
        }

    }

    public class class2 : IDisposable
    {
        public class2()
        {
            //open file here 
            //open db here 

        }
        bool isDisposed;
        public void Display()
        {
            CheckForDisposed();
            Console.WriteLine("Display Called ");
        }
        public void Dispose()
        {
            CheckForDisposed();
            //Close File
            //Close db Connection 
            Console.WriteLine("Dispose code called . Write code here instead of Destructor  ");
            isDisposed = true;
        }
       

        private void CheckForDisposed()
        {
            if(isDisposed)
                throw new ObjectDisposedException("Class1");
        }
    }
}
