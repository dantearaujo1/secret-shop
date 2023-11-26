import 'package:bd_project/widgets/bottomBar.dart';
import 'package:flutter/material.dart';

final textSize = 18.0;
final backColor = Color(0xffB99791);

class ProductPage extends StatelessWidget {
  const ProductPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        toolbarHeight:100,
        automaticallyImplyLeading:false,
        title:Row(
          mainAxisAlignment:MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children:[Column(
            children:[
              Image(image: AssetImage('assets/product.png')),
              Container(height:10),
              Row(
                children:[
                  Text("CADASTRO",style:TextStyle(color:Colors.white)),
                  Container(width:10),
                  Text("PRODUTO",style:TextStyle(fontWeight:FontWeight.w700, color:Colors.white)),
                ]
              )
            ]
          )
        ]),
        backgroundColor:backColor
      ),
      body: Center(
        child: Column(
          mainAxisAlignment:MainAxisAlignment.spaceAround,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            Form(
              child:Column(
                children:[
                  Padding(
                    padding:const EdgeInsets.symmetric(vertical:2),
                    child:Container(
                      width:400 ,
                      child:Text("Código Cliente", style: TextStyle(fontSize:textSize, color: backColor))
                    )
                  ),
                  Padding(
                    padding:const EdgeInsets.fromLTRB(0,0,0,16),
                    child:Container(
                      width:400 ,
                      child:TextField(
                        decoration: InputDecoration(
                          border: OutlineInputBorder(
                            borderRadius:BorderRadius.circular(1)
                          )
                        )
                      )
                    )
                  ),
                  Padding(
                    padding:const EdgeInsets.symmetric(vertical:2),
                    child:Container(
                      width:400 ,
                      child:Text("Nome Completo", style: TextStyle(fontSize:textSize, color: backColor))
                    )
                  ),
                  Padding(
                    padding:const EdgeInsets.fromLTRB(0,0,0,16),
                    child:Container(
                      width:400 ,
                      child:TextField(
                        decoration: InputDecoration(
                          border: OutlineInputBorder(
                            borderRadius:BorderRadius.circular(1)
                          )
                        )
                      )
                    )
                  ),
                  Padding(
                    padding:const EdgeInsets.symmetric(vertical:2),
                    child:Container(
                      width:400 ,
                      child:Text("Telefone", style: TextStyle(fontSize:textSize, color: backColor))
                    )
                  ),
                  Padding(
                    padding:const EdgeInsets.fromLTRB(0,0,0,16),
                    child:Container(
                      width:400 ,
                      child:TextField(
                        decoration: InputDecoration(
                          border: OutlineInputBorder(
                            borderRadius:BorderRadius.circular(1)
                          )
                        )
                      )
                    )
                  ),
                  Container(
                    height:60,
                  ),
                  TextButton(
                    onPressed:(){print("Hello Button");},
                    child:Container(
                      width:200,
                      height:60,
                      color:backColor,
                      child:Center(
                        child:Text("CADASTRAR",style:TextStyle(color:Colors.white,fontSize:24))
                      )
                    )
                  )
                ]
              )
            ),
            Container(
              width:500,
              child: Column(
                mainAxisAlignment:MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children:[
                  Container(
                    width:400,
                    child:Divider(),
                  ),
                  Row(
                    mainAxisAlignment:MainAxisAlignment.center,
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children:[
                      BottomBar()
                    ]
                  )
                ]
              ),
            ),
          ]
        )
      ),
    );
  }
}
