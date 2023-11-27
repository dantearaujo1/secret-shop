import 'package:flutter/material.dart';

class ErrorPage extends StatelessWidget {
  const ErrorPage({
    super.key,
    required this.onPressed,
  });

  final Function() onPressed;

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          const Text(
            'Infelizmente tivemos um erro',
            style: TextStyle(fontSize: 24),
          ),
          const SizedBox(
            height: 48,
          ),
          ElevatedButton(
            onPressed: onPressed,
            child: Text('Tentar novamente'),
          ),
        ],
      ),
    );
  }
}
