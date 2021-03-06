package com.demo.state;
/**
 * State Pattern으로 Light 1을 구현
 * 객체 생성보다 싱글턴으로 구성하는 것이 메모리 관리 측면에서 좋음
 * @author hsoo3
 * @since 20181017
 */
public class Light2 {
	public static interface State {
		public void onButtonPushed(Light light);
		public void offButtonPushed(Light light);
	}
	
	public static class On implements State {

		@Override
		public void onButtonPushed(Light light) {
			System.out.println("반응 없음");
		}

		@Override
		public void offButtonPushed(Light light) {
			System.out.println("Light off");
			light.setState(new Off());
		}
	}
	
	public static class Off implements State {

		@Override
		public void onButtonPushed(Light light) {
			System.out.println("Light On");
			light.setState(new On());
		}

		@Override
		public void offButtonPushed(Light light) {
			System.out.println("반응없음");
		}
		
	}
	
	public static class Light {
		private State state;
		public Light() {
			state = new Off();
		}
		
		public void setState(State state) {
			this.state = state;
		}
		
		public void onButtonPushed() {
			state.onButtonPushed(this);
		}
		
		public void offButtonPushed() {
			state.offButtonPushed(this);
		}
	}
	
	public static void main(String[] args) {
		Light light = new Light();
		light.offButtonPushed();
		light.onButtonPushed();
		light.onButtonPushed();
		light.offButtonPushed();
		light.offButtonPushed();
	}
}