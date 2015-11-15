//***************************************************************************** 
//cinco 
//***************************************************************************** 
 object cinco{ 
    
   def mayorQue8 (x:Int):Boolean={ 
     var resultado=false; 
     if (x>8){ 
       resultado=true; 
     } 
     resultado; 
   } 

   def par(x:Int):Boolean={ 
     var resultado=false; 
     if (x%2==0){ 
       resultado=true; 
     } 
     resultado; 
   } 
    
   def impar(x:Int):Boolean={ 
     var resultado=false; 
     if (x%2==1){ 
       resultado=true; 
     } 
     resultado; 
   } 

    
   def numTests(lista:List[(Int)=>Boolean],numero:Int):Int={         
       var resultado=0; 
      
       for (funcion <- lista){ 
         var resul_Func = funcion(numero); 
         if (resul_Func) 
           resultado=resultado+1; 
       } 
       resultado; 
   } 
      
      
   def main(args: Array[String]) { 
     try{ 
        var numero=Integer.parseInt(args.head); 
        val lista=List(mayorQue8 _,par _,impar _); 
        numTests(lista,numero); 
      
     }catch{ 
       case e: NumberFormatException => println("Error el parámetro recibido, debe introducir un número"); 
       case e: Exception => println(e.printStackTrace()); 
       System exit 1; 
     } 
   } 
 } 