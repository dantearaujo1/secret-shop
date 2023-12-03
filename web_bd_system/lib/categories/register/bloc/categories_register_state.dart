import 'package:equatable/equatable.dart';

abstract class CategoriesRegisterState extends Equatable {
  const CategoriesRegisterState();

  @override
  List<Object?> get props => [];
}

final class CategoriesRegisterLoadingState extends CategoriesRegisterState {}

final class CategoriesRegisterErrorState extends CategoriesRegisterState {}

final class CategoriesRegisterSuccessState extends CategoriesRegisterState {}
