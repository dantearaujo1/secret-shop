import 'package:equatable/equatable.dart';
import 'package:web_bd_system/clients/home/api/client_model.dart';

abstract class ClientState extends Equatable {
  const ClientState();

  @override
  List<Object?> get props => [];
}

final class ClientLoadingState extends ClientState {}

final class ClientErrorState extends ClientState {}

final class ClientSuccessState extends ClientState {
  final List<ClientModel> clients;

  const ClientSuccessState(this.clients);

  @override
  List<Object?> get props => [clients];
}

final class ClientDeletionSuccess extends ClientState {}


final class ClientDeletionError extends ClientState {}