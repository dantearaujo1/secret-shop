import 'package:equatable/equatable.dart';

abstract class ClientEvent extends Equatable {
  const ClientEvent();

  @override
  List<Object?> get props => [];
}

final class ClientRequestEvent extends ClientEvent {}

final class ClientRequestDeleteEvent extends ClientEvent {
  final String id;

  const ClientRequestDeleteEvent(this.id);

  @override
  List<Object?> get props => [id];
}