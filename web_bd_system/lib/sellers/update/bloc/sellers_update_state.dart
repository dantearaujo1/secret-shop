import 'package:equatable/equatable.dart';

abstract class SellersUpdateState extends Equatable {
  const SellersUpdateState();

  @override
  List<Object?> get props => [];
}

final class SellersUpdateLoadingState extends SellersUpdateState {}

final class SellersUpdateErrorState extends SellersUpdateState {}

final class SellersUpdateSuccessState extends SellersUpdateState {}
