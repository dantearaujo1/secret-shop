import 'package:bd_project/widgets/bottomBar.dart';
import 'package:flutter/material.dart';
ThemeData themeData = ThemeData(
  primaryColor: const Color(0xffBC006C),
  useMaterial3: true,
  fontFamily: 'Krub'
);

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Secret Beauty',
      theme: themeData,
      home: Scaffold(
        body: Expanded(
          child:Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment:CrossAxisAlignment.center,
              children:<Widget>[
                  Image(image: AssetImage("assets/Group 3.png")),
                  Column(
                    crossAxisAlignment:CrossAxisAlignment.end,
                    children:<Widget>[
                      Container(
                        width:400,
                        child: Column(
                          crossAxisAlignment:CrossAxisAlignment.end,
                          children:[
                            Text("SECRET",textAlign:TextAlign.right,style:TextStyle(fontSize:50,color:Color(0xFFBC006C),fontWeight:FontWeight.w200)),
                            Text("BEAUTY",style:TextStyle(fontSize:60,color:Color(0xFFBC006C),fontWeight:FontWeight.w900)),
                            Text("COSMETIC COMPANY",style:TextStyle(fontSize:21,color:Color(0xFFBC006C),fontWeight:FontWeight.w200)),
                          ]
                        )
                      )
                    ]
                  ),
                Container(
                  height:100,
                ),
                Container(
                  width:400,
                  child: Divider(),
                ),
                Row(
                  mainAxisAlignment:MainAxisAlignment.center,
                  children: [
                    BottomBar()
                  ],
                ),
              ]
            )
          )
        )
      ),
    );
  }
}
