import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:web_bd_system/sellers/register/api/sellers_post_model.dart';
import 'package:web_bd_system/sellers/register/bloc/sellers_register_bloc.dart';
import 'package:web_bd_system/sellers/register/bloc/sellers_register_event.dart';
import 'package:web_bd_system/sellers/register/bloc/sellers_register_state.dart';
import 'package:web_bd_system/utils/app_colors.dart';

class SellersRegister extends StatelessWidget {
  SellersRegister({super.key});

  final TextEditingController _textFieldControllerName =
      TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text(
          'Secret Beauty',
        ),
      ),
      body: BlocListener<SellersRegisterBloc, SellersRegisterState>(
        listener: (context, state) {
          switch (state.runtimeType) {
            case SellersRegisterSuccessState:
              Navigator.pop(context);
          }
        },
        child: Column(
          children: [
            const Padding(
              padding: EdgeInsets.all(24.0),
              child: Text('Cadastro de Vendedores',
                  style: TextStyle(fontSize: 20)),
            ),
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: 24),
              child: TextField(
                decoration: const InputDecoration(
                  border: OutlineInputBorder(),
                  labelText: 'Digite o nome do vendedor',
                ),
                controller: _textFieldControllerName,
              ),
            ),
            const SizedBox(
              height: 32,
            ),
            GestureDetector(
              onTap: () {
                final name = _textFieldControllerName.text;
                final model = SellersPostModel(name);

                context
                    .read<SellersRegisterBloc>()
                    .add(SellersRegisterRequestEvent(model));
              },
              child: Padding(
                padding: const EdgeInsets.symmetric(horizontal: 24.0),
                child: Container(
                  width: double.infinity,
                  decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(8),
                    color: AppColors.primaryColor,
                  ),
                  child: const Padding(
                    padding: EdgeInsets.all(20.0),
                    child: Text(
                      'Cadastrar',
                      textAlign: TextAlign.center,
                      style:
                          TextStyle(fontSize: 20, fontWeight: FontWeight.w500),
                    ),
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
