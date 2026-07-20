using Interfaces1;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Interfaces1
{
    internal class Program
    {
        static void Main1()
        {
            Class1 o = new Class1();
            o.Display();
            //method1
            o.Insert();

            //method 3
            IDbfunctions oIDb;
            oIDb = o;
            oIDb.Insert();

            //method 3
            ((IDbfunctions)o).Insert();

            //method4
            (o as IDbfunctions).Insert();

            Console.ReadLine();
        }
    }
    public interface IDbfunctions
    {
        void Insert();
        void Update();
        void Delete();
    }
    public class Class1 : IDbfunctions
    {
        public void Display()
        {
            Console.WriteLine("Display");
        }
        public void Delete()
        {
            Console.WriteLine("Class1-IDb.Delete");
        }
        public void Insert()
        {
            Console.WriteLine("Class1-IDb.Insert");
        }
        public void Update()
        {
            Console.WriteLine("Class1-IDb.Update");
        }
    }
}

namespace Interfaces2
{
    internal class Program
    {
        static void Main(IFileFunctions o1)
        {
            Class1 o = new Class1();

            (o as IDbfunctions).Delete();
            o.Delete();



            IFileFunctions oIFile;
            oIFile = (IFileFunctions)o;
            oIFile.Delete();

            Console.ReadLine();
        }
    }
    public interface IDbfunctions
    {
        void Insert();
        void Update();
        void Delete();
    }

    public interface IFilefunctions
    {
        void Open();
        void Close();
        void Delete();
    }
    public class Class1 : IDbfunctions,IFilefunctions
    {
        public void Display()
        {
            Console.WriteLine("Display");
        }
        public void Delete()
        {
            Console.WriteLine("Class1-IDb.Delete");
        }
        public void Insert()
        {
            Console.WriteLine("Class1-IDb.Insert");
        }
        public void Update()
        {
            Console.WriteLine("Class1-IDb.Update");
        }

        void IFilefunctions.Open()
        {
            throw new NotImplementedException();
        }

        void IFilefunctions.Close()
        {
            throw new NotImplementedException();
        }

        void IDbfunctions.Delete()
        {
            throw new NotImplementedException();
        }

        public void Open()
        {
            Console.WriteLine("Class1-IFile.Open");
        }
        public void Close()
        {
            Console.WriteLine("Class1 - IFile.Close");
        }
    }
}

namespace Interfaces3
{
    class Program
    {
        //Polymorphic code
        static void Main(String[] args)
        {
            Class1 obj1 = new Class1();
            Class2 obj2 = new Class2();

            IDbfunctions oIDb;
            oIDb = obj1;
            oIDb.Insert();

            Console.ReadLine();
        }
        static void Main()
        {
            Class1 o1 = new Class1();
            Class2 o2 = new Class2();
            InsertMethod(o1);
            InsertMethod(o2);

        }
        static void InsertMethod(IDbfunctions oIDb)//can receive an object of any class that implements IDbFunctions
        {
            oIDb.Insert();
        }    
    }
    public interface IDbFunctions
    {
        void Insert();
        void Update();
        void Delete();
    }

    public class class1 : IDbFunctions
    {
        public void Delete()
        {
            Console.WriteLine("Class1 - IDb.Delete");
        }
        public void Display()
        {
            Console.WriteLine("Display");
        }
        public void Insert()
        {
            Console.WriteLine("Class1 - IDb.Insert");
        }
        public void Update()
        {
            Console.WriteLine("Class1-IDb.Update");
        }
        public class class2 : IDbFunctions
        {
            public void Delete()
            {
                Console.WriteLine("Class2 - IDb.Delete");
            }
            public void Display()
            {
                Console.WriteLine("Class2-IDb.Delete");
            }

            public void Insert()
            {
                Console.WriteLine("Class2-IDb.Insert()");
            }

            public void Update()
            {
                Console.WriteLine("Class2-IDb.Update()");
            }
        }
    }
}

/*
 * Advantages of Interfaces
 * 
 * Contract - class MUST implement all the interface methods
 * similar code in entire project for all developers
 * polymorphic code
 * design pattern 
 */

//to do -try inheritance in interfaces 
//

