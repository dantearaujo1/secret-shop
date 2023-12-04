import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:web_bd_system/clients/register/api/client_post_model.dart';
import 'package:web_bd_system/clients/register/bloc/client_register_bloc.dart';
import 'package:web_bd_system/clients/register/bloc/client_register_event.dart';
import 'package:web_bd_system/clients/register/bloc/client_register_state.dart';
import 'package:web_bd_system/utils/app_colors.dart';

class ClientRegister extends StatelessWidget {
  ClientRegister({super.key});

  final TextEditingController _textFieldControllerName =
      TextEditingController();
  final TextEditingController _textFieldControllerDDD = TextEditingController();
  final TextEditingController _textFieldControllerPhone =
      TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text(
          'Secret Beauty',
        ),
      ),
      body: BlocListener<ClientRegisterBloc, ClientRegisterState>(
        listener: (context, state) {
          switch (state.runtimeType) {
            case ClientRegisterSuccessState:
              Navigator.pop(context);
          }
        },
        child: Column(
          children: [
            const Padding(
              padding: EdgeInsets.all(24.0),
              child:
                  Text('Cadastro de cliente', style: TextStyle(fontSize: 20)),
            ),
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: 24),
              child: TextField(
                decoration: const InputDecoration(
                  border: OutlineInputBorder(),
                  labelText: 'Digite o nome do cliente',
                ),
                controller: _textFieldControllerName,
              ),
            ),
            const SizedBox(
              height: 24,
            ),
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: 24),
              child: TextField(
                decoration: const InputDecoration(
                  border: OutlineInputBorder(),
                  labelText: 'Digite o DDD',
                ),
                controller: _textFieldControllerDDD,
              ),
            ),
            const SizedBox(
              height: 24,
            ),
            Padding(
              padding: const EdgeInsets.symmetric(horizontal: 24),
              child: TextField(
                decoration: const InputDecoration(
                  border: OutlineInputBorder(),
                  labelText: 'Digite o número de telefone',
                ),
                controller: _textFieldControllerPhone,
              ),
            ),
            const SizedBox(
              height: 32,
            ),
            GestureDetector(
              onTap: () {
                final name = _textFieldControllerName.text;
                final ddd = _textFieldControllerDDD.text;
                final phone = _textFieldControllerPhone.text;
                final model = ClientPostModel(name, ddd, phone);

                context
                    .read<ClientRegisterBloc>()
                    .add(ClientRegisterRequestEvent(model));
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
