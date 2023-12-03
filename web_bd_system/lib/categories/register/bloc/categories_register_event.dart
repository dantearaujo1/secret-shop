import 'package:equatable/equatable.dart';
import 'package:web_bd_system/categories/register/api/categories_post_model.dart';

abstract class CategoriesRegisterEvent extends Equatable {
  const CategoriesRegisterEvent();

  @override
  List<Object?> get props => [];
}

final class CategoriesRegisterRequestEvent extends CategoriesRegisterEvent {
  final CategoriesPostModel model;

  const CategoriesRegisterRequestEvent(this.model);
}
