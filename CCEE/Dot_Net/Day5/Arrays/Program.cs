using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Arrays
{
    internal class Program
    {
        static void Main1()
        {
            int[] arr = new int[5];
            //arr[0] .. arr[4]
            for(int i = 0; i < arr.Length; i++)
            {
                Console.WriteLine("Enter arr[{0}] : ", i);
                arr[i]=int.Parse(Console.ReadLine());
                //arr[i] = Convert.ToInt32(Console.ReadLine());

            }
            for (int i = 0; i < arr.Length; i++)
            {
                //Console.WriteLine("arr[{0}]:{1}", i, arr[i]); // placeholders
                Console.WriteLine($"The value of arr[{i}] is {arr[i]} is {arr[i]}");//String interpolation 
            }
            foreach(var item in arr)
            {
                Console.WriteLine(item);
            }
            Console.ReadLine();
        }

        static void Main2()
        {
            int[] arr = new int[5];
            //arr[0] .. arr[4]
            for (int i = 0; i < arr.Length; i++)
            {
                Console.WriteLine("Enter arr[{0}] : ", i);
                arr[i] = int.Parse(Console.ReadLine());
                //arr[i] = Convert.ToInt32(Console.ReadLine());

            }
            //for(int i = 0; i < arr.Length; i++)
            //{
            //    //Console.WriteLine("arr[{0}]:{1}", i, arr[i]); // placeholders
            //    Console.WriteLine($"The value of arr[{i}] is {arr[i]} is {arr[i]}");//String interpolation 
            //}

            //int pos = Array.IndexOf(arr, 10);
            //int pos = Array.LastIndexOf(arr, 10);
            int pos = Array.BinarySearch(arr, 10);

            if (pos == -1)
            {
                Console.WriteLine("Not Found");
            }
            //Array.Clear(arr, 0, arr.Length);
            //Array.Copy(arr, arr2, arr.length);
            //Array.ConstrainedCopy(arr, 0, arr2, 0, arr.length);
            Array.Sort(arr);
            Array.Reverse(arr);
            foreach (var item in arr)
            {
                Console.WriteLine(item);
            }
            Console.ReadLine();
        }

        static void Main()
        {
            int[,] arr = new int[3, 2];
            //arr[0,0] arr[0,1]
            //arr[1,0] arr[1,1]
            //arr[2,0] arr[2,1]

            Console.WriteLine(arr.Length);//6
            Console.WriteLine(arr.Rank);//number of dimensions - 2

            Console.WriteLine(arr.GetLength(0));//3
            Console.WriteLine(arr.GetLength(1));//2

            Console.WriteLine(arr.GetUpperBound(0));//3
            Console.WriteLine(arr.GetUpperBound(1));//1

            for (int i = 0; i < arr.GetLength(0); i++) 
            {
                for(int j = 0; j < arr.GetLength(1); j++)
                {
                    Console.Write("Enter arr[{0},{1}] : ", i,j);
                    arr[i,j]=int.Parse(Console.ReadLine());

                }
                
            }
            for(int i = 0; i < arr.GetLength(0); i++)
            {
                for(int j = 0; j < arr.GetLength(1); j++)
                {
                    Console.WriteLine($"The Value of arr[{i},{j}]  is {arr[i,j]} ");//string interpolation 
                }
            }
            foreach(int item in arr)
            {
                Console.WriteLine(item);
            }
            Console.ReadLine();
        }

    }
    //cdac has 5 students , each students has three marks 
    //int [5,3] arr=new int[5,3];

    //cdac has 2 batches, each batch has 5 students , each students has 3 marks
    //int [2,5,3] arr=new int[2,5,3];

    //cdac has 3 centers , each center has 2 batches , each batch has 5 students , each students has 3 marks 
    //int [3,2,5,3] arr=new int [2,5,3];

    //cdac is in 4 cities , each city hs 3 centres, each center has 2 batches ,each batches has 5 students 
    //int [4,3,2,5,3] arr=new int[4,3,2,5,]
    3



}
