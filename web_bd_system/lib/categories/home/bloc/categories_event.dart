import 'package:equatable/equatable.dart';

abstract class CategoriesEvent extends Equatable {
  const CategoriesEvent();

  @override
  List<Object?> get props => [];
}

final class CategoriesRequestEvent extends CategoriesEvent {}

final class CategoriesRequestDeleteEvent extends CategoriesEvent {
  final String id;

  const CategoriesRequestDeleteEvent(this.id);

  @override
  List<Object?> get props => [id];
}