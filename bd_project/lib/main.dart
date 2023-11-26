import 'package:bd_project/pages/home_page.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(
    MaterialApp(
      home: MyApp()
    )
  );
}

ThemeData themeData = ThemeData(
  primaryColor: const Color(0xffBC006C),
  useMaterial3: true,
  fontFamily: 'Krub'
);

class MyApp extends StatelessWidget {

  const MyApp({super.key});
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Secret Beauty',
      theme: themeData,
      home: HomePage()
    );
  }
}

