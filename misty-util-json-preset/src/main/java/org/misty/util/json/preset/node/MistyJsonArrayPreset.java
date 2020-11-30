package org.misty.util.json.preset.node;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.misty.util.json.api.node.MistyJson;
import org.misty.util.json.api.node.MistyJsonArray;

public class MistyJsonArrayPreset extends MistyJsonAbstract implements MistyJsonArray {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	private final Collection<MistyJson> collection;

	/* [instance] constructor */

	public MistyJsonArrayPreset() {
		this.collection = new LinkedList<>();
	}

	public MistyJsonArrayPreset(Collection<MistyJson> collection) {
		this.collection = collection;
	}

	/* [instance] method */

	@Override
	public String getString() {
		return this.collection.toString();
	}

	//

	@Override
	public int size() {
		return this.collection.size();
	}

	@Override
	public boolean isEmpty() {
		return this.collection.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return this.collection.contains(o);
	}

	@Override
	public Iterator<MistyJson> iterator() {
		return this.collection.iterator();
	}

	@Override
	public Object[] toArray() {
		return this.collection.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return this.collection.toArray(a);
	}

	@Override
	public boolean add(MistyJson e) {
		return this.collection.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return this.collection.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return this.collection.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends MistyJson> c) {
		return this.collection.addAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return this.collection.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return this.collection.retainAll(c);
	}

	@Override
	public void clear() {
		this.collection.clear();
	}

	/* [instance] getter/setter */

}
