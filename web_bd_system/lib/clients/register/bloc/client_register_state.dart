import 'package:equatable/equatable.dart';

abstract class ClientRegisterState extends Equatable {
  const ClientRegisterState();

  @override
  List<Object?> get props => [];
}

final class ClientRegisterLoadingState extends ClientRegisterState {}

final class ClientRegisterErrorState extends ClientRegisterState {}

final class ClientRegisterSuccessState extends ClientRegisterState {}
