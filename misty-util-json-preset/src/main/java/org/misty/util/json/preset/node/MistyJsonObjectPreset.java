package org.misty.util.json.preset.node;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.misty.util.json.api.node.MistyJson;
import org.misty.util.json.api.node.MistyJsonObject;

public class MistyJsonObjectPreset extends MistyJsonAbstract implements MistyJsonObject {

	/* [static] field */

	/* [static] */

	/* [static] method */

	/* [instance] field */

	private final Map<String, MistyJson> map;

	private final boolean sequenceable;

	/* [instance] constructor */

	public MistyJsonObjectPreset() {
		this.map = new LinkedHashMap<>();
		this.sequenceable = false;
	}

	public MistyJsonObjectPreset(Comparator<String> comparator) {
		this.map = new TreeMap<>(comparator);
		this.sequenceable = true;
	}

	/* [instance] method */

	@Override
	public String getString() {
		return this.map.toString();
	}

	//

	@Override
	public int size() {
		return this.map.size();
	}

	@Override
	public boolean isEmpty() {
		return this.map.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return this.map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return this.map.containsValue(value);
	}

	@Override
	public MistyJson get(Object key) {
		return this.map.get(key);
	}

	@Override
	public MistyJson put(String key, MistyJson value) {
		return this.map.put(key, value);
	}

	@Override
	public MistyJson remove(Object key) {
		return this.map.remove(key);
	}

	@Override
	public void putAll(Map<? extends String, ? extends MistyJson> m) {
		this.map.putAll(m);
	}

	@Override
	public void clear() {
		this.map.clear();
	}

	@Override
	public Set<String> keySet() {
		return this.map.keySet();
	}

	@Override
	public Collection<MistyJson> values() {
		return this.map.values();
	}

	@Override
	public Set<Entry<String, MistyJson>> entrySet() {
		return this.map.entrySet();
	}

	@Override
	public boolean isSequenceable() {
		return this.sequenceable;
	}

	/* [instance] getter/setter */

}
