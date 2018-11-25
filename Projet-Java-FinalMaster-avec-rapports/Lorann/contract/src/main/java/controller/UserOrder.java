package controller;

public class UserOrder implements IUserOrder {
			
			public int player;
			public Order order;
		
			public UserOrder(int player, Order order) {
				this.player = player;
				this.order = order;
		}
			
			@Override
			public void getOrder() {
				// TODO Auto-generated method stub
		
			}
		
			@Override
			public void getPlayer() {
			// TODO Auto-generated method stub
		
			}

}
