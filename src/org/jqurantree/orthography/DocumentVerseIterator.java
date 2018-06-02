/* Copyright (C) Kais Dukes, 2009.
 * 
 * This file is part of JQuranTree.
 * 
 * JQuranTree is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * JQuranTree is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with JQuranTree. If not, see <http://www.gnu.org/licenses/>.
 */

package org.jqurantree.orthography;

import java.util.Iterator;

import org.jqurantree.core.collections.ImmutableIteratorBase;

class DocumentVerseIterator extends ImmutableIteratorBase<Verse> implements
		Iterable<Verse> {

	private final Chapter[] chapters;
	private Verse[] verses;
	private int chapterNumber;
	private int verseNumber;

	public DocumentVerseIterator(Chapter[] chapters) {
		this.chapters = chapters;
	}

	public Iterator<Verse> iterator() {
		return this;
	}

	public boolean hasNext() {
		return chapterNumber < Document.CHAPTER_COUNT
				|| verseNumber < verses.length;
	}

	public Verse next() {
		if (verses == null || ++verseNumber > verses.length) {
			verses = chapters[++chapterNumber - 1].verses;
			verseNumber = 1;
		}
		return verses[verseNumber - 1];
	}
}
