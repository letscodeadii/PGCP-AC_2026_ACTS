using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

//why inheritance - code reusability 
//base//parent//super
//derived/child/sub

//-----------------------------------
//Single Inheritance 

//class baseclass{}
//class derivedclass : baseclass { }

//-----------------------------------

//multiple inheritance - Not allow in  .net  //ambiquity 
//class baseclass1{}
//class baseclass2{}

//class derivedclass : baseclass1, baseclass2 {}
//---------------------------------------

//multi level inheritance 
//class baseclass{a,b}
//class derivedclass: baseclass{c,d}
//class subderivedclass : derivedclass{e,f}


//access specifiers
namespace InheritanceExamples2
{
    class Program
    {
        static void Main1()
        {
            //BaseClass o = new BaseClass();
            //o.

            TestAccessSpecifiers.BaseClass o2=new TestAccessSpecifiers.BaseClass(); 
            //o2.   //public 
          

        }

    }

    //access specifiers
    //  
    //private- same class
    //public - everywhere 
    //protected - same class,derived class
    //internal - same class, same assembly (same project)
    //protected internal - same class , derived class, same assembly(same project)
    //private protected - same class , derived class which are in the same assembly 
    public class BaseClass
    {
        public int PUBLIC;
        private int PRIVATE;
        protected int PROTECTED;
        internal int INTERNAL;
        protected internal int PROTECTED_INTERNAL;
        private protected int PRIVATE_PROTECTED;
        int x;//default private 

    }
    public class DerivedClass:TestAccessSpecifiers.BaseClass //:BaseClass
    {
        void DoNothing()
        {
            //this.
        }
    }

    
}







