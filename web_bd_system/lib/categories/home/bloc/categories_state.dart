import 'package:equatable/equatable.dart';
import 'package:web_bd_system/categories/home/api/categories_model.dart';

abstract class CategoriesState extends Equatable {
  const CategoriesState();

  @override
  List<Object?> get props => [];
}

final class CategoriesLoadingState extends CategoriesState {}

final class CategoriesErrorState extends CategoriesState {}

final class CategoriesSuccessState extends CategoriesState {
  final List<CategoriesModel> categories;

  const CategoriesSuccessState(this.categories);

  @override
  List<Object?> get props => [categories];
}

final class CategoriesDeletionSuccess extends CategoriesState {}

final class CategoriesDeletionError extends CategoriesState {}
