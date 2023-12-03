import 'package:equatable/equatable.dart';
import 'package:web_bd_system/sellers/home/api/sellers_model.dart';

abstract class SellersState extends Equatable {
  const SellersState();

  @override
  List<Object?> get props => [];
}

final class SellersLoadingState extends SellersState {}

final class SellersErrorState extends SellersState {}

final class SellersSuccessState extends SellersState {
  final List<SellersModel> sellers;

  const SellersSuccessState(this.sellers);

  @override
  List<Object?> get props => [sellers];
}

final class SellersDeletionSuccess extends SellersState {}


final class SellersDeletionError extends SellersState {}