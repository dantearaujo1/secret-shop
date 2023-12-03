import 'package:equatable/equatable.dart';

abstract class CategoriesUpdateState extends Equatable {
  const CategoriesUpdateState();

  @override
  List<Object?> get props => [];
}

final class CategoriesUpdateLoadingState extends CategoriesUpdateState {}

final class CategoriesUpdateErrorState extends CategoriesUpdateState {}

final class CategoriesUpdateSuccessState extends CategoriesUpdateState {}
