import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:web_bd_system/clients/register/api/client_register_service.dart';
import 'package:web_bd_system/clients/register/bloc/client_register_event.dart';
import 'package:web_bd_system/clients/register/bloc/client_register_state.dart';

class ClientRegisterBloc
    extends Bloc<ClientRegisterEvent, ClientRegisterState> {
  ClientRegisterBloc(this.service) : super(ClientRegisterLoadingState()) {
    on<ClientRegisterRequestEvent>(_request);
  }

  final ClientRegisterService service;

  void _request(ClientRegisterRequestEvent event,
      Emitter<ClientRegisterState> emit) async {
    try {
      final _ = await service.createClient(event.model);
      emit(ClientRegisterSuccessState());
    } catch (e) {
      emit(ClientRegisterErrorState());
    }
  }
}
