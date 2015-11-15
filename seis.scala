/** 
 * @author Sergio San Sotero Hernando 
 */ 

class Dato(numOp:Int, numComp:Int){ 
  var numOperacion = numOp; 
  var numComparar = numComp; 
  
} 

object seis{ 
    
   def mayorQue (x:Dato):Boolean={ 
     var resultado=false; 
     if (x.numComparar>x.numOperacion){ 
       resultado=true; 
     } 
     resultado; 
   } 


   def menorQue(x:Dato):Boolean={ 
     var resultado=false; 
     if (x.numComparar<x.numOperacion){ 
       resultado=true; 
     } 
     resultado; 
   } 
    
   def igualQue(x:Dato):Boolean={ 
     var resultado=false; 
     if (x.numOperacion < x.numComparar || x.numOperacion > x.numComparar){ 
       resultado=false; 
     }else{ 
       resultado=true;   
     } 
     resultado; 
   } 


    
   def numTests(lista:List[(Dato)=>Boolean],numOp:List[Int], numero:Int):Int={         
       var resultado=0; 
       var indice=0; 
       var resul_Func=false; 
       for (funcion <- lista){ 
         var numerosAComparar = new Dato (numOp(indice),numero); 
         resul_Func = funcion(numerosAComparar); 
         //println("Resultado Func:"+resul_Func+" Vuelta:"+indice); 
         if (resul_Func){ 
           resultado=resultado+1; 
         } 
         //println("Temp:"+resultado+" Vuelta:"+indice); 
         indice =indice+1; 
       } 
       println("Numero de test correctos: "+resultado); 
       resultado; 
   } 
      
      
   def main(args: Array[String]) { 
     try{ 
        var numero=Integer.parseInt(args.head); 
        val listaEntrada=List(">","3","<","5",">","8","=","10"); 
      
        var listaOperadores=List[(Dato)=>Boolean](); 
        var listaOperandos=List[Int](); 
        
        var contador=0; 
        for (ele <- listaEntrada){ 
          contador=contador+1; 
          
          if (contador%2==1){ 
            var operador : (Dato)=>Boolean = menorQue _; 
            ele match{ 
              case "<" => operador = menorQue _; 
              case ">" => operador = mayorQue _; 
              case "=" => operador = igualQue _; 
            } 
            listaOperadores ::= operador; 
            
          }else if (contador%2==0){ 
            listaOperandos ::= ele.toInt; 
          } 
        }//for 
        
        numTests(listaOperadores,listaOperandos,numero); 
          
     }catch{ 
       case e: NumberFormatException => {println("Error el parámetro recibido, debe introducir un número"); println(e.printStackTrace())}; 
       case e: Exception => println(e.printStackTrace()); 
       System exit 1; 
     } 
   } 
 } 