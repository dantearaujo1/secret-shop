import 'package:equatable/equatable.dart';
import 'package:web_bd_system/clients/register/api/client_post_model.dart';

abstract class ClientRegisterEvent extends Equatable {
  const ClientRegisterEvent();

  @override
  List<Object?> get props => [];
}

final class ClientRegisterRequestEvent extends ClientRegisterEvent {
  final ClientPostModel model;

  const ClientRegisterRequestEvent(this.model);
}
