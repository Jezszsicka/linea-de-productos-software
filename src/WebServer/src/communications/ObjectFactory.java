package communications;


import Ice.Object;
import ProductLine.Filter;
import ProductLine.Game;
import ProductLine.User;


public class ObjectFactory implements Ice.ObjectFactory {

	@Override
	public Object create(String type) {
		if (type.equals(Game.ice_staticId())) {
            return new model.Game();
        }
		if (type.equals(User.ice_staticId())){
			return new model.User();
		}

		if (type.equals(Filter.ice_staticId())){
			return new model.Filter();
		}
			
        return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
