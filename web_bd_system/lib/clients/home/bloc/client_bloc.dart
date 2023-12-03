import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:web_bd_system/clients/home/api/client_service.dart';
import 'package:web_bd_system/clients/home/bloc/client_event.dart';
import 'package:web_bd_system/clients/home/bloc/client_state.dart';

class ClientBloc extends Bloc<ClientEvent, ClientState> {
  ClientBloc(this.service) : super(ClientLoadingState()) {
    on<ClientRequestEvent>(_request);
    on<ClientRequestDeleteEvent>(_delete);
  }

  final ClientService service;

  void _request(ClientRequestEvent event, Emitter<ClientState> emit) async {
    emit(ClientLoadingState());
    try {
      final clients = await service.getClients();
      emit(ClientSuccessState(clients));
    } catch (e) {
      emit(ClientErrorState());
    }
  }

  void _delete(
      ClientRequestDeleteEvent event, Emitter<ClientState> emit) async {
    try {
      await service.delete(event.id);
      emit(ClientDeletionSuccess());
    } catch (e) {
      emit(ClientDeletionError());
    }
  }
}
