import 'package:equatable/equatable.dart';
import 'package:web_bd_system/categories/update/api/categories_update_model.dart';

abstract class CategoriesUpdateEvent extends Equatable {
  const CategoriesUpdateEvent();

  @override
  List<Object?> get props => [];
}

final class CategoriesUpdateRequestEvent extends CategoriesUpdateEvent {
  final CategoriesUpdateModel model;

  const CategoriesUpdateRequestEvent(this.model);
}
