
import 'package:equatable/equatable.dart';

abstract class SellersRegisterState extends Equatable {
  const SellersRegisterState();

  @override
  List<Object?> get props => [];
}

final class SellersRegisterLoadingState extends SellersRegisterState {}

final class SellersRegisterErrorState extends SellersRegisterState {}

final class SellersRegisterSuccessState extends SellersRegisterState {}
